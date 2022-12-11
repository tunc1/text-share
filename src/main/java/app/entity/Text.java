package app.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Text
{
    @Id
    @SequenceGenerator(name="TEXT_SEQUENCE_GENERATOR",sequenceName="TEXT_SEQUENCE",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="TEXT_SEQUENCE_GENERATOR")
    private Long id;
    private String text;
    private LocalDateTime expireDate;
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id=id;
    }
    public String getText()
    {
        return text;
    }
    public void setText(String text)
    {
        this.text=text;
    }
    public LocalDateTime getExpireDate()
    {
        return expireDate;
    }
    public void setExpireDate(LocalDateTime expireDate)
    {
        this.expireDate=expireDate;
    }
}