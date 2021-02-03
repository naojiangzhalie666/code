package com.lin.sleeve.model;

import org.hibernate.annotations.Where;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Ztiany
 * Email ztiany3@gmail.com
 * Date 2021/1/22 20:10
 */
@Entity
@Getter
@Setter
@ToString
//对所有查询都加上一个条件，应用场景：逻辑删除的数据不应该被查询出来。
@Where(clause = "delete_time is null")
public class Theme extends BaseEntity {

    @Id
    private Long id;

    private String title;
    private String name;
    private String description;

    private String entranceImg;
    private String internalTopImg;

    private String titleImg;

    private String extend;

    private String tplName;

    private Boolean online;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "theme_spu",
            joinColumns = @JoinColumn(name = "theme_id"),
            inverseJoinColumns = @JoinColumn(name = "spu_id")
    )
    private List<Spu> spuList;

}
