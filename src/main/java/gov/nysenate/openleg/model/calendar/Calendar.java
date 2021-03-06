package gov.nysenate.openleg.model.calendar;

import gov.nysenate.openleg.model.SenateObject;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.Cacheable;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Order;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
@XmlRootElement
@Cacheable
@XStreamAlias("calendar")
public class Calendar  extends SenateObject implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9107882529284115806L;
	
	
	@Persistent
	@Column(name="year")
	@XStreamAsAttribute
	private int year;
	
	@Persistent
	@Column(name="type")
	@XStreamAsAttribute
	private String type;
	
	@Persistent
	@Column(name="session_year")
	@XStreamAsAttribute
	private int sessionYear;
	
	@Persistent
	@Column(name="no")
	@XStreamAsAttribute
	private int no;
	
	
	
	
	
	
	
	@Persistent(serialized = "false",defaultFetchGroup="true",mappedBy="calendar")
	@Join
	@Element(dependent = "true")  
	@Order(column="integer_idx")
	private List<Supplemental> supplementals;
	
	
	
	
	
	
	
	

	@Persistent
	@PrimaryKey
	@Column(name="id", jdbcType="VARCHAR", length=100)
	private String id;	
	
	public final static String TYPE_FLOOR = "floor";
	public final static String TYPE_ACTIVE = "active";
	
	
	
	
	/**
	 * @return the id
	 */
	@XmlTransient
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	

	/**
	 * @return the no
	 */
	 @XmlAttribute
	public int getNo() {
		return no;
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}

	/**
	 * @return the sessionYear
	 */
	 @XmlAttribute
	public int getSessionYear() {
		return sessionYear;
	}

	/**
	 * @param sessionYear the sessionYear to set
	 */
	public void setSessionYear(int sessionYear) {
		this.sessionYear = sessionYear;
	}

	/**
	 * @return the year
	 */
	 @XmlAttribute
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	

	/**
	 * @return the type
	 */
	@XmlAttribute
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	

	/**
	 * @return the supplementals
	 */

	@XmlElementWrapper(name = "supplementals")
	@XmlElement(name = "supplemental")
	public List<Supplemental> getSupplementals() {
		return supplementals;
	}

	/**
	 * @param supplementals the supplementals to set
	 */
	public void setSupplementals(List<Supplemental> supplementals) {
		this.supplementals = supplementals;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (obj != null && obj instanceof Calendar)
		{
			if ( ((Calendar)obj).getId().equals(this.getId()))
				return true;
		}
		
		return false;
	}

	
}
