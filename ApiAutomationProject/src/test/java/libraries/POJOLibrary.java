package libraries;

public class POJOLibrary {
/*
   	  "name":"Gouda",
       "salary":"123",
       "age":"23"

 */
	
	String name;
	String salary;
	String age;
	
	public void setName(String name) {
		this.name =name;
	}
	
	public void setSalary(String salary) {
		this.salary=salary;
		
	}
	
	public void setAge(String age) {
		this.age= age;
	}

	public String getName() {
		return name;
	}
	public String getSalary() {
		return salary;
	}


	public String getAge() {
	return age;
	
}
	
}
