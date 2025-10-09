package org.softwaretechnologies.employee;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * Тип сотрудника
 */
public enum EmployeeType {
    /*
    Формула вычисления зп: если месяц четный, то baseSalary, иначе baseSalary/2
     */
    Manager{
        public Employee createEmployee(String name, int baseSalary) {
            return new Employee(name,baseSalary) {
                @Override
                public int getMonthSalary(int month) {
                    return (month%2==0 ? baseSalary: baseSalary/2);
                }
            };
        }
    },

    /*
    Формула вычисления зп: всегда baseSalary
     */
    Programmer{
        public Employee createEmployee(String name, int baseSalary) {
            return new Employee(name,baseSalary) {
                @Override
                public int getMonthSalary(int month) {
                    return baseSalary;
                }
            };
        }
    },
    /*
    Формула вычисления зп: baseSalary * количество дней в месяце в текущем году
    Вычисление количества дней в месяце: YearMonth.of(LocalDate.now().getYear(), month).lengthOfMonth()
     */
    Tester{
        public Employee createEmployee(String name, int baseSalary) {
            return new Employee(name,baseSalary) {
                @Override
                public int getMonthSalary(int month) {
                    return baseSalary*YearMonth.of(LocalDate.now().getYear(), month).lengthOfMonth();
                }
            };
        }
    };
    public abstract Employee createEmployee(String name, int baseSalary);

}
