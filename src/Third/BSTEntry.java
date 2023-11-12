package Third;

public class BSTEntry {
    protected int clave;
    protected Object data;

    public BSTEntry(int k, Object d) {
        this.clave=k;
        this.data =d;
    }
    
    public Object getData() {
    	return data;
    }
    
    public int getKey() {
    	return clave;
    }
    
    public void setData(Object d) {
    	this.data=d;
    }
    
    public void setKey(int k) {
    	this.clave=k;
    }
    @Override
    public String toString() {
        return "Key: " + this.getKey() + ", Data: " + this.getData().toString();
    }
 
}
