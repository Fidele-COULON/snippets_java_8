package fr.fidtec.beans;

public class User {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	 @Override
     public boolean equals(Object obj) {
         if ((obj == null) || ! (obj instanceof User)) return false;

         User other = (User) obj;

         return this.name !=null ? this.name.equals(other.name) : this.name == other.name;
     }
	 
	 protected boolean canEqual(Object o) {
         return o instanceof User;
     }	 
}
