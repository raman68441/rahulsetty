package pojo;

public class GetCourse {
	
	private String url;
	private String services;
	private String expertise;
	private Course Courses;
	private String instructions;
	private String linkedIn;
	
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public String getUrl() {
		return url;
	}
	
		public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public Course getCourses() {
		return courses;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	public void setCourses(Course courses) {
		this.courses = courses;
	}
	public String getInstruciton() {
		return instruciton;
	}
	public void setInstruciton(String instruciton) {
		this.instruciton = instruciton;
	}
	private Course courses;
	private String instruciton;
	

}
