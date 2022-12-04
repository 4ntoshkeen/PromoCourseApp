package ru.antoshkeen.springcourse.FirstSecurityApp.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "operationdate")
    private String operationDate;

    @OneToMany(mappedBy = "owner")
    private List<Tool> tools;

    @OneToMany(mappedBy = "owner")
    private List<Operation> operations;

    @Column(name = "cito")
    private String cito;
    @Column(name = "timestart")
    private String timeStart;
    @Column(name = "timefinish")
    private String timeFinish;
    @Column(name = "personname")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 3, max = 100, message = "Name should be between 3 and 100 characters")
    private String name;
    @Column(name = "region")
    private String region;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "department")
    private String department;

    @Column(name = "historynumber")
    private int historyNumber;
    @Column(name = "timedose")
    private String timeDose;

    @Column(name = "dose")
    @Min(value = 0, message = "This value should be greater than 0")
    private int dose;
    @Column(name = "stents")
    @Min(value = 0, message = "This value should be greater than 0")
    private int stents;

    @Column(name = "elevation")
    private String elevation;

    /*@Column(name = "operatordoc")
    @Enumerated(EnumType.STRING)
    private Operator operator;

    @Column(name = "assistant")
    @Enumerated(EnumType.STRING)
    private Assistant assistant;

    @Column(name = "operNurse")
    @Enumerated(EnumType.STRING)
    private OperNurse operNurse;

    @Column(name = "nurse")
    @Enumerated(EnumType.STRING)
    private Nurse nurse;

    @Column(name = "laboratorian")
    @Enumerated(EnumType.STRING)
    private Laboratorian laboratorian;

    @Column(name = "anesthesiologistDoc")
    @Enumerated(EnumType.STRING)
    private AnesthesiologistDoc anesthesiologistDoc;

    @Column(name = "anesthesiologistNurse")
    @Enumerated(EnumType.STRING)
    private AnesthesiologistNurse anesthesiologistNurse;

    @Column(name = "cardiologist")
    @Enumerated(EnumType.STRING)
    private Cardiologist cardiologist;

*/





    public Person(String operationDate,
                  String cito,
                  String timeStart,
                  String timeFinish,
                  String name,
                  String region,
                  String birthday,
                  String department,
                  int historyNumber,
                  String timeDose,
                  int dose,
                  int stents,
                  String elevation, List<Tool> tools, List<Operation> operations) {
        this.operationDate = operationDate;
        this.cito = cito;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
        this.name = name;
        this.region = region;
        this.birthday = birthday;
        this.department = department;
        this.historyNumber = historyNumber;
        this.timeDose = timeDose;
        this.dose = dose;
        this.stents = stents;
        this.elevation = elevation;
        this.tools = tools;
        this.operations = operations;
    }

    public Person() {
        // Just an empty constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(String operationDate) {
        this.operationDate = operationDate;
    }

    public String getCito() {
        return cito;
    }

    public void setCito(String cito) {
        this.cito = cito;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeFinish() {
        return timeFinish;
    }

    public void setTimeFinish(String timeFinish) {
        this.timeFinish = timeFinish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getHistoryNumber() {
        return historyNumber;
    }

    public void setHistoryNumber(int historyNumber) {
        this.historyNumber = historyNumber;
    }

    public String getTimeDose() {
        return timeDose;
    }

    public void setTimeDose(String timeDose) {
        this.timeDose = timeDose;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public int getStents() {
        return stents;
    }

    public void setStents(int stents) {
        this.stents = stents;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

   /* public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    public OperNurse getOperNurse() {
        return operNurse;
    }

    public void setOperNurse(OperNurse operNurse) {
        this.operNurse = operNurse;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public Laboratorian getLaboratorian() {
        return laboratorian;
    }

    public void setLaboratorian(Laboratorian laboratorian) {
        this.laboratorian = laboratorian;
    }

    public AnesthesiologistDoc getAnesthesiologistDoc() {
        return anesthesiologistDoc;
    }

    public void setAnesthesiologistDoc(AnesthesiologistDoc anesthesiologistDoc) {
        this.anesthesiologistDoc = anesthesiologistDoc;
    }

    public AnesthesiologistNurse getAnesthesiologistNurse() {
        return anesthesiologistNurse;
    }

    public void setAnesthesiologistNurse(AnesthesiologistNurse anesthesiologistNurse) {
        this.anesthesiologistNurse = anesthesiologistNurse;
    }

    public Cardiologist getCardiologist() {
        return cardiologist;
    }

    public void setCardiologist(Cardiologist cardiologist) {
        this.cardiologist = cardiologist;
    }*/

    public List<Tool> getTools() {
        return tools;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }
}
