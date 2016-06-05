package cr.ac.itcr.exm_sugef.model;

/**
 * Created by usuario on 4/6/2016.
 */
public class Transaction {
    String _id,date,type,rode,active;

    public Transaction() {
        this._id = _id;
        this.date = date;
        this.type = type;
        this.rode = rode;
        this.active = active;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRode() {
        return rode;
    }

    public void setRode(String rode) {
        this.rode = rode;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
