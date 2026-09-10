public class WRM {
    Patient dh;

    //The constructor is already created for you
    public WRM() {
        dh = new Patient(null, null, null, null, null, null);
        dh.next = dh;
        dh.prev = dh;
    }

    public void registerPatient(int id, String name, int age, String bloodgroup) {
        Patient newPatient = new Patient (id, name, age, bloodgroup, null, null);
        Patient x = dh.prev;
        x.next = newPatient;
        newPatient.prev = x;
        dh.prev = newPatient;
        newPatient = dh.next;
    }

    public void servePatient() {
        if(dh.next != dh && dh.prev != dh){
            Patient temp = dh.next.next;
            temp.prev = dh;
            dh.next = temp;
        }
        else{
            return;
        }
    }

    public void showAllPatient() {
        Patient n = dh.next;
            while(n != dh){
                System.out.println(n.id);
                n = n.next;
            }
            n.next = dh;
    }

    public Boolean canDoctorGoHome() {
        Boolean a = null;
        if(dh.next == dh && dh.prev == dh){
            a = true;
        }
        else{
            a = false;
        }
        return a; // Delete this line once you're ready
    }

    public void cancelAll() {
        dh.next = dh;
        dh.prev = dh;
    }


    public void reverseTheLine() {
        Patient n = dh.next.next;
        Patient after = n.next;
        while(n != dh){
            after.next = n;
            after.prev = dh;
            n = n.next;
            after = after.next;
        }
    }

}