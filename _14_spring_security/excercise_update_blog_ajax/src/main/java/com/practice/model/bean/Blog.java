package com.practice.model.bean;

import javax.persistence.*;
import java.sql.Date;


//Năm nay dịch quá, trận này vừa qua trận khác lại ào đến. Để hạn chế lây lan, thành phố đưa ra biện phápn mỗi người dân chỉ được phéo đi chợ 3 ngà y 1 lần.
//Sáng nay vừa ra đến chợ mà tôi hãi hùng toát mồ hôi hột, vì ngày mai toàn thành phố sẽ bị đóng băng, nên người người nhà nhà tranh nhau đi trợ dự trữ lương thực thực phẩm.
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Date createDate;
    @Column(columnDefinition = "LONGBLOB")
    private String content;

    //ManyToOne: (1 blog chỉ thuộc 1 thể loại - 1 thể loại có thể có nhiều bài blog)
    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(Integer id, String title, Date createDate, String content, Category category) {
        this.id = id;
        this.title = title;
        this.createDate = createDate;
        this.content = content;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
