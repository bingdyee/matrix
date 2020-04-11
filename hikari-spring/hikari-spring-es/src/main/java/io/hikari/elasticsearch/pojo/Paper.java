package io.hikari.elasticsearch.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @author Noa Swartz
 * @date 2020-04-11
 */
@Document(indexName = "hikari_es", type = "paper")
public class Paper {

    @Id
    private Long id;
    /** 论文标题 */
    @Field
    private String title;
    /** 论文DOI */
    @Field
    private String doi;
    /** 全文PDF url */
    @Field
    private String fullText;

    public Paper() { }

    public Paper(Long id, String title, String doi, String fullText) {
        this.id = id;
        this.title = title;
        this.doi = doi;
        this.fullText = fullText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }


    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", doi='" + doi + '\'' +
                ", fullText='" + fullText + '\'' +
                '}';
    }

}
