package com.hrmanagement.hr_management.config;

//@Component
public class DataInitializer  {
    /*
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;
    private final LeaveTypeRepository leaveTypeRepository;
    private final ProjectRepository projectRepository;
    private final LeaveRequestRepository LeaveRequestRepository;
    private final LeaveApprovalRepository leaveApprovalRepository;
    private final TimesheetRepository timesheetRepository;

    public DataInitializer(RoleRepository roleRepository, PermissionRepository permissionRepository,
                           DepartmentRepository departmentRepository, UserRepository userRepository,
                           LeaveTypeRepository leaveTypeRepository, ProjectRepository projectRepository,
                           LeaveRequestRepository  LeaveRequestRepository, LeaveApprovalRepository leaveApprovalRepository,
                           TimesheetRepository timesheetRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.departmentRepository = departmentRepository;
        this.userRepository = userRepository;
        this.leaveTypeRepository = leaveTypeRepository;
        this.projectRepository = projectRepository;
        this.LeaveRequestRepository = LeaveRequestRepository;
        this.leaveApprovalRepository = leaveApprovalRepository;
        this.timesheetRepository = timesheetRepository;
    }

    @Override
    public void run(String... args) {
        if (roleRepository.count() == 0) {
            System.out.println("🔹 Adding default roles...");
            Role adminRole = roleRepository.save(new Role(null, "Admin"));
            Role managerRole = roleRepository.save(new Role(null, "Manager"));
            Role employeeRole = roleRepository.save(new Role(null, "Employee"));

            // Permissions
           // still need to write it .


            System.out.println("🔹 Adding default departments...");
            Department hr = departmentRepository.save(new Department(null, "HR", null));
            Department it = departmentRepository.save(new Department(null, "IT", null));
            Department finance = departmentRepository.save(new Department(null, "Finance", null));

            System.out.println("🔹 Adding default users...");
            User admin = userRepository.save(new User(null, "admin@example.com", "123456", adminRole, hr, null, LocalDate.of(2023, 1, 1), LocalDateTime.now(), LocalDateTime.now()));
            User manager = userRepository.save(new User(null, "manager@example.com", "123456", managerRole, it, admin, LocalDate.of(2023, 2, 1), LocalDateTime.now(), LocalDateTime.now()));
            User employee = userRepository.save(new User(null, "employee@example.com", "123456", employeeRole, finance, manager, LocalDate.of(2023, 3, 1), LocalDateTime.now(), LocalDateTime.now()));

            System.out.println("🔹 Adding default leave types...");
            LeaveType annualLeave = leaveTypeRepository.save(new LeaveType(null, "Annual Leave", 30));
            LeaveType sickLeave = leaveTypeRepository.save(new LeaveType(null, "Sick Leave", 10));

            System.out.println("🔹 Adding default projects...");
            Project projectA = projectRepository.save(new Project(null, "Project A", "Description A"));
            Project projectB = projectRepository.save(new Project(null, "Project B", "Description B"));

            System.out.println("🔹 Adding default leave requests...");
            LeaveRequest leave1 = LeaveRequestRepository.save(new LeaveRequest(
                null, employee, annualLeave,
                LocalDate.of(2024, 3, 1), LocalDate.of(2024, 3, 5),
                LocalDateTime.now(), LocalDateTime.now()
            ));

            LeaveRequest leave2 = LeaveRequestRepository.save(new LeaveRequest(
                null, manager, sickLeave,
                LocalDate.of(2024, 2, 15), LocalDate.of(2024, 2, 18),
                LocalDateTime.now(), LocalDateTime.now()
            ));


            System.out.println("🔹 Adding default leave approvals...");
            leaveApprovalRepository.save(new LeaveApproval(null, leave1, manager, ApprovalStatus.APPROVED, LocalDateTime.now()));
            leaveApprovalRepository.save(new LeaveApproval(null, leave2, admin, ApprovalStatus.REJECTED, LocalDateTime.now()));
            System.out.println("🔹 Adding default timesheets...");
            timesheetRepository.save(new Timesheet(null, employee, projectA,
                LocalDateTime.of(2024, 2, 28, 9, 0),
                LocalDateTime.of(2024, 2, 28, 17, 0),
                LocalDateTime.now(),
                LocalDateTime.now()));
            timesheetRepository.save(new Timesheet(null, manager, projectB,
                LocalDateTime.of(2024, 2, 28, 9, 0),
                LocalDateTime.of(2024, 2, 28, 18, 0),
                LocalDateTime.now(),
                LocalDateTime.now()));
            System.out.println("✅ Default data inserted successfully!");
        } else {
            System.out.println("✅ Data already exists. Skipping initialization.");
        }
    }

     */
}
