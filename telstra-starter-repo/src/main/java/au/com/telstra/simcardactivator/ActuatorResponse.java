package au.com.telstra.simcardactivator;

public record ActuatorResponse(){
    private static boolean success;

    public boolean isSuccess(){
        return success;
    }
    public void setSuccess(boolean success){
        ActuatorResponse.success = success;
    }
}
