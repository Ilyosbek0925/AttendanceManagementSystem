package school;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import school.service.AdminService;
@SpringBootTest
public class AdminTest {
 @Autowired
    AdminService adminService;


    @Test
    public void testAdminGet() {
        System.out.println(adminService.
                getAllAdmins());

    }

}
