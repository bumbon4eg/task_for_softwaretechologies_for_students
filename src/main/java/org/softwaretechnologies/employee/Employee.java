package org.softwaretechnologies.employee;

/**
 * Создайте классы, наследуемые от Employee и представляющие каждый из типов указанный в enum EmployeeType.
 * Для каждого из них реализуйте функцию getMonthSalary по следующим формулам:
 * Tester: baseSalary * количество дней в месяце в текущем году. Вычисление количества дней в месяце: YearMonth.of(LocalDate.now().getYear(), month).lengthOfMonth()
 * Manager: если месяц четный, то baseSalary, иначе baseSalary/2
 * Programmer: всегда baseSalary
 */
public abstract class Employee {
    protected String name;
    protected int baseSalary;

    protected Employee(String name, int baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    protected Employee() {
    }

    public abstract int getMonthSalary(int month);

    public String getName() {
        return name;
    }
}
