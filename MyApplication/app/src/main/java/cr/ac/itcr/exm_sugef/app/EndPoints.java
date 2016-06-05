package cr.ac.itcr.exm_sugef.app;

/**
 * Created by usuario on 3/6/2016.
 */
public class EndPoints {

    /**
     * localhost url o your actual ip config
     *
     */

    public static final String BASE_URL = "http://192.168.0.5:9000";
    public static final String NEW_TRANSACTION = BASE_URL + "/api/sugef/transaction/new";
    public static final String NEW_USER = BASE_URL + "/api/sugef/users/new";
    public static final String GET_TRANSACTIONS = BASE_URL + "/api/sugef/transaction/all";
    public static final String GET_USERS = BASE_URL + "/api/sugef/users/all";
    public static final String GET_TRANSACTION = BASE_URL + "/api/sugef/transaction/:id";
    public static final String GET_USER = BASE_URL + "/api/sugef/users/:user";
    public static final String EDIT_TRANSACTION = BASE_URL + "/api/sugef/transaction/edit";
    public static final String DELETE_TRANSACTION = BASE_URL + "/api/sugef/transaction/delete/:idTransaction";
    public static final String DISABLE_TRANSACTION = BASE_URL + "/api/sugef/transaction/disable";

}
