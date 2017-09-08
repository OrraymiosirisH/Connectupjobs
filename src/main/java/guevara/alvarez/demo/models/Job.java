package guevara.alvarez.demo.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name="SKILL_DATA")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "company")
    private String company;


    @Column(name = "post_name")
    private String postname;


    @Column(name = "title")
    private String title;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "salary")
    private String salary;


    @Column(name = "description")
    private String desc;

    @Column(name = "skill")
    private String ski;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Collection<Skill> skiller;

    public Job() {
        this.setSkiller(new HashSet<Skill>());
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPostname() {
        return postname;
    }

    public void setPostname(String postname) {
        this.postname = postname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSki() {
        return ski;
    }

    public void setSki(String ski) {
        this.ski = ski;
    }

    public Collection<Skill> getSkiller() {
        return skiller;
    }

    public void setSkiller(Collection<Skill> skiller) {
        this.skiller = skiller;
    }

    public void addSkill(guevara.alvarez.demo.models.Skill kil) {
        skiller.add(kil);
    }



}