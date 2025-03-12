package com.hrmanagement.hr_management.models;
import com.hrmanagement.hr_management.enums.ApprovalStatus;
import lombok.*;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Data

@Table(name = "leave_approvals")
public class LeaveApproval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leave_request_id", nullable = false)
    private LeaveRequest leaveRequest;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "approved_by", nullable = false)
    private User approvedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ApprovalStatus status = ApprovalStatus.PENDING;

    @Column(name = "approval_timestamp", nullable = false)
    private LocalDateTime approvalTimestamp = LocalDateTime.now();
}
