package guevara.alvarez.demo.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;


@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String ski;

    @ManyToMany(mappedBy = "skiller", fetch = FetchType.LAZY)
    private Collection<Job> jobs;

    public Skill(){

        this.jobs=new HashSet<Job>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Collection<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Collection<Job> jobs) {
        this.jobs = jobs;
    }

    public void addJob(Job jobsite)
    {
        jobs.add(jobsite);
    }

    public String getSki() {
        return ski;
    }

    public void setSki(String ski) {
        this.ski = ski;
    }
}
