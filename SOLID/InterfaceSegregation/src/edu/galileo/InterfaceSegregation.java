package edu.galileo;

/*
 * Don't Depend on things you won't need.
 */

public class InterfaceSegregation {

    public static void main(String[] args) throws Exception {
        MaquilaFactory maquilaX = new MaquilaFactory();
        SodaFactory sodaX = new SodaFactory();
        CarFactory carX = new CarFactory();
    }
}


class MaquilaFactory implements ProductionDepartment, DeliveryDepartment{
    public MaquilaFactory(){;}
    public void manufacture(){;};
    public void transformRawMaterial(){;};
    public void logistics(){;};
    public void distribution(){;};
}

class SodaFactory implements ProductionDepartment, AdministrativeDepartment, InvestigationDepartment{
    public SodaFactory(){;}
    public void manufacture(){;};
    public void transformRawMaterial(){;};
    public void administration(){;};
    public void accountancy(){;};
    public void createNewProduct(){;};
    public void costReduction(){;};
}

class CarFactory implements ProductionDepartment, InvestigationDepartment{
    public CarFactory(){;}
    public void manufacture(){;};
    public void transformRawMaterial(){;};
    public void createNewProduct(){;};
    public void costReduction(){;};
}

//Bad Implementation
interface Factory {
    void administration();
    void manufacture();
    void accountancy();
    void transformRawMaterial();
    void createNewProduct();
    void costReduction();
    void logistics();
    void distribution();
}

//Better Implementation applying Interface Segregation
//Segregate Factory interface on Department interfaces
interface AdministrativeDepartment {
    void administration();
    void accountancy();
}

interface ProductionDepartment {
    void manufacture();
    void transformRawMaterial();
}

interface InvestigationDepartment {
    void createNewProduct();
    void costReduction();
}

interface DeliveryDepartment {
    void logistics();
    void distribution();
}