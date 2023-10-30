package Actividad6;

public class App implements CalculoOperacional{
    private String name;
    private int users;
    private double monthlyCost;
    private double monthlyProfit;
    private int yearlyUsers;

    //Constructor vacio
    public App(){}

    //Contructor para no tener que pasar por setters
    public App(String name, int users, double monthlyCost){
        this.name = name;
        this.users = users;
        this.monthlyCost = monthlyCost;
        calculateMonthlyProfit();
        projectYearlyUsers();
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public void calculateMonthlyProfit() {
        monthlyProfit = users * monthlyCost;
    }

    public void projectYearlyUsers() {
        yearlyUsers = users * MESES;
    }

    //Getters
    public double getMonthlyCost() {
        return monthlyCost;
    }
    public double getMonthlyProfit() {
        return monthlyProfit;
    }
    public String getName() {
        return name;
    }
    public int getUsers() {
        return users;
    }
    public int getYearlyUsers() {
        return yearlyUsers;
    }

    @Override
    public String toString() {
        return "Aplicación: " + name + 
        "\nCantidad Usuarios: " + users + 
        "\nCosto Mensual: " + monthlyCost + 
        "\nGanancia Neta Mensual: " + monthlyProfit + 
        "\nTotal de Usuarios para el Cierre del Año: " + yearlyUsers;
    }
}
