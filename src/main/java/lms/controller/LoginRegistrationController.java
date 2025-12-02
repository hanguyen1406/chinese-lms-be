package lms.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dto.TokenDTO;
import lms.dto.UserDTO;
import lms.model.ERole;
import lms.model.MessageResponse;
import lms.model.Role;
import lms.model.User;
import lms.model.UserDetailsImpl;
import lms.service.RoleService;
import lms.service.UserService;
import lms.token.TokenUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class LoginRegistrationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private TokenUtils tokenUtils;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserDTO userDTO) {
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
	
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwtToken = tokenUtils.generateJwtToken(authentication);
			
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
			List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
			TokenDTO jwtDTO = new TokenDTO(jwtToken, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles);
			
			return new ResponseEntity<TokenDTO>(jwtDTO, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Người dùng không tồn tại!"));
		}
	}

	@PostMapping("/registration")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserDTO userDTO) {
		if (userService.existsByUsername(userDTO.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username đã tồn tại!"));
		}

		if (userService.existsByEmail(userDTO.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email đã tồn tại!"));
		}

		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		user.setPassword(encoder.encode(user.getPassword()));
		Set<Role> roles = new HashSet<>();
		Role userRole = roleService.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: không có loại user này."));

		roles.add(userRole);
		user.setRoles(roles);
		userService.save(user);
		return ResponseEntity.ok(new MessageResponse("Tài khoản đăng ký thành công!"));
	}
}
