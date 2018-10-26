package gm.desafio.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "work_hours")
public class WorkHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @ManyToOne
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startWork;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endWork;

    private Long timeWorked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStartwork() {
        return startWork;
    }

    public void setStartwork(Date startWork) {
        this.startWork = startWork;
    }

    public Date getEndWork() {
        return endWork;
    }

    public void setEndWork(Date endWork) {
        this.endWork = endWork;
    }

    public Long getTimeWorked(Date startWork, Date endWork) {
        return (this.endWork.getTime() - this.startWork.getTime()) / 1000;
    }

}
