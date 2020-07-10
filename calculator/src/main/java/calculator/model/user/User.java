package calculator.model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id =:userId")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
@NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username =:username")
@XmlRootElement
@Entity
public class User implements Serializable
{
    private static final long serialVersionUID = 1L;

    public static final String findById = "User.findByID";
    public static final String findAll = "User.findAll";
    public static final String findByUsername = "User.findByUsername";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column
    private boolean solved;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public boolean isSolved()
    {
        return solved;
    }

    public void setSolved(boolean solved)
    {
        this.solved = solved;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)(id ^ (id >>> 32));
        result = prime * result + (solved ? 1231 : 1237);
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        User other = (User)obj;
        if(id != other.id)
            return false;
        if(solved != other.solved)
            return false;
        if(username == null)
        {
            if(other.username != null)
                return false;
        }
        else if(!username.equals(other.username))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "User [id=" + id + ", username=" + username + ", solved=" + solved + "]";
    }

}
