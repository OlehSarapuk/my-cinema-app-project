package cinema.util;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.service.RoleService;
import cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Initializer {
    private final RoleService roleService;
    private final UserService userService;
    private final AuthenticationService authenticationService;

    public Initializer(RoleService roleService,
                       UserService userService,
                       AuthenticationService authenticationService) {
        this.roleService = roleService;
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setName(Role.RoleName.USER);
        roleService.add(userRole);

        User admin = new User();
        admin.setEmail("admin@i.ua");
        admin.setPassword("admin1234");
        admin.setRoles(Set.of(adminRole));
        userService.add(admin);

        authenticationService.register("user@i.ua", "user1234");
    }
}
