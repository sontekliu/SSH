package com.trekiz.hibernate.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="code")
	private String code;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private Integer age;
	@Column(name="sex")
	private String sex;
	@Column(name="address")
	private String address;
	@Column(name="card_id")
	private String cardId;
	@Column(name="birth_date")
	private Date birthDate;
	@Column(name="createBy")
	private Integer createBy;
	@Column(name="createDate")
	private Date createDate;
	@Column(name="updateBy")
	private Integer updateBy;
	@Column(name="updateDate")
	private Date updateDate;
	
	public Student(){
		
	}
	public Student(String code, String name, String address){
		this.code = code;
		this.name = name;
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return "Student:" + this.getId() + ":" + this.getCode() + ":" + this.getName() + ":" + this.getSex() +
				":" + this.getAge() + ":" + this.getCardId() + ":" + this.getAddress() + ":" +this.getBirthDate() + ":" +
				this.getCreateBy() + ":" + this.getUpdateDate();
	}
	
}