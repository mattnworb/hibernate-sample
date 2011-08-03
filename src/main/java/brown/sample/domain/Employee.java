package brown.sample.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Matt Brown
 * @since: 8/3/11
 */
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Date employmentStartDate;

    /**
     * Bi-directional relationship between Company and Employee.
     */
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    /**
     * Unidirectional relationship between Employee and Team.
     */
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getEmploymentStartDate() {
        return employmentStartDate;
    }

    public void setEmploymentStartDate(Date employmentStartDate) {
        this.employmentStartDate = employmentStartDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
