package com.zb.mybatis.generator.pojo;

public class Emp {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_emp.id
     *
     * @mbggenerated Sun Jul 17 19:27:14 CST 2022
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_emp.emp_name
     *
     * @mbggenerated Sun Jul 17 19:27:14 CST 2022
     */
    private String empName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_emp.age
     *
     * @mbggenerated Sun Jul 17 19:27:14 CST 2022
     */
    private Integer age;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_emp.sex
     *
     * @mbggenerated Sun Jul 17 19:27:14 CST 2022
     */
    private String sex;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_emp.id
     *
     * @return the value of t_emp.id
     *
     * @mbggenerated Sun Jul 17 19:27:14 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_emp.id
     *
     * @param id the value for t_emp.id
     *
     * @mbggenerated Sun Jul 17 19:27:14 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_emp.emp_name
     *
     * @return the value of t_emp.emp_name
     *
     * @mbggenerated Sun Jul 17 19:27:14 CST 2022
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_emp.emp_name
     *
     * @param empName the value for t_emp.emp_name
     *
     * @mbggenerated Sun Jul 17 19:27:14 CST 2022
     */
    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_emp.age
     *
     * @return the value of t_emp.age
     *
     * @mbggenerated Sun Jul 17 19:27:14 CST 2022
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_emp.age
     *
     * @param age the value for t_emp.age
     *
     * @mbggenerated Sun Jul 17 19:27:14 CST 2022
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_emp.sex
     *
     * @return the value of t_emp.sex
     *
     * @mbggenerated Sun Jul 17 19:27:14 CST 2022
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_emp.sex
     *
     * @param sex the value for t_emp.sex
     *
     * @mbggenerated Sun Jul 17 19:27:14 CST 2022
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }


    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Emp() {
    }

    public Emp(Integer id, String empName, Integer age, String sex) {
        this.id = id;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
    }
}