package fr.fidtec.beans;

public class UserWithPassword extends UserWithHashCode {
	private String password;

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
    public boolean equals(Object obj) {
        if(! super.equals(obj)) return false;

        if(! (obj instanceof UserWithPassword) ) return false;

        UserWithPassword other = (UserWithPassword) obj;

        if(! other.canEqual(this)) return false;
        
        return this.password !=null ? this.password.equals(other.password) : this.password == other.password;
    }

	@Override
    protected boolean canEqual(Object o) {
        return o instanceof UserWithPassword;
    }
	
    @Override
    public int hashCode() {
        return super.hashCode() + (password == null ? 0 : password.length());
    }
}
