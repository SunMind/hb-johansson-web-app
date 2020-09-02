package springdemo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transport_ticket")
public class TransportTicket {

    @Id
    //.IDENTITY - It relies on an auto-incremented database column
    // and lets the database generate a new value with each insert operation.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "extra_info")
    private String extraInfo;

    @Column(name = "worked_hours")
    private float workedHours;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "employee_person_id")
    private Employee employee;

    public TransportTicket(){}

    public TransportTicket( Date date, String extraInfo, float workedHours, Employee employee) {
        this.date = date;
        this.extraInfo = extraInfo;
        this.workedHours = workedHours;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public float getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(float workedHours) {
        this.workedHours = workedHours;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "TransportTicket{" +
                "id=" + id +
                ", date=" + date +
                ", extraInfo='" + extraInfo + '\'' +
                ", workedHours=" + workedHours +
                ", employee=" + employee +
                '}';
    }
}
