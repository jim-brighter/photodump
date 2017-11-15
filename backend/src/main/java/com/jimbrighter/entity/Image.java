package com.jimbrighter.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "IMAGES")
public class Image implements Serializable {

	private static final long serialVersionUID = 4627997033693883334L;

	@Id
	@SequenceGenerator(name = "image_gen", sequenceName = "IMAGE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_gen")
	@Column(name = "IMG_ID")
	private long id;
	
	@Column(name = "IMG_TITLE")
	private String title;
	
	@Column(name = "IMG_URL")
	private String url;
	
	@Column(name = "IMG_SUBMITTER")
	private String submitter;

	public Image() {
		super();
	}

	public Image(String title, String url, String submitter) {
		super();
		this.title = title;
		this.url = url;
		this.submitter = submitter;
	}
	
	public Image(int id) {
		this.id = (long) id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSubmitter() {
		return submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", title=" + title + ", url=" + url + ", submitter=" + submitter + "]";
	}
}
