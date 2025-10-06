package org.softwaretechnologies;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Random;

import static java.lang.Integer.MAX_VALUE;

public class Money {
    private final MoneyType type;
    private final BigDecimal amount;

    public Money(MoneyType type, BigDecimal amount) {
        this.type = type;
        this.amount = amount;
    }

    /**
     * Money равны, если одинаковый тип валют и одинаковое число денег до 4 знака после запятой.
     * Округление по правилу: если >= 5, то в большую сторону, интаче - в меньшую
     * Пример округления:
     * BigDecimal scale = amount.setScale(4, RoundingMode.HALF_UP);
     *
     * @param o объект для сравнения
     * @return true - равно, false - иначе
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }else if (o instanceof Money) {
            if (this.amount==null||((Money) o).amount==null) {
                return (this.amount==null&&((Money) o).amount==null);
            } else {
                return ((Objects.equals(this.amount.setScale(4, RoundingMode.HALF_UP), ((Money) o).amount.setScale(4, RoundingMode.HALF_UP))
                        && (Objects.equals(this.type, ((Money) o).type))));
            }
        }
        return false;
    }

    /**
     * Формула:
     * (Если amount null 10000, иначе количество денег окрукленные до 4х знаков * 10000) + :
     * если USD , то 1
     * если EURO, то 2
     * если RUB, то 3
     * если KRONA, то 4
     * если null, то 5
     * Если amount округленный до 4х знаков * 10000 >= (Integer.MaxValue - 5), то хеш равен Integer.MaxValue
     * Округление по правилу: если >= 5, то в большую сторону, иначе - в меньшую
     * Пример округления:
     * BigDecimal scale = amount.setScale(4, RoundingMode.HALF_UP);
     *
     * @return хеш код по указанной формуле
     */
    @Override
    public int hashCode() {

        if (this.amount==null) {
            return 10000;
        }

        BigDecimal scaledAmount = amount.setScale(4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(10_000));
        if (scaledAmount.compareTo(BigDecimal.valueOf(MAX_VALUE - 5)) >= 0) {
            return MAX_VALUE;
        } else {
            int tmp = this.amount.setScale(4, RoundingMode.HALF_UP).intValue();

            if (type == null) {
                tmp += 5;
                return tmp;
            }

            switch (this.type) {
                case USD -> {
                    tmp += 1;
                    }
                    case EURO -> {
                        tmp += 2;
                        break;
                    }
                    case RUB -> {
                        tmp += 3;
                        break;
                    }
                    case KRONA -> {
                        tmp += 4;
                        break;
                    }
                    default -> {
                        tmp += 5;
                        break;
                    }
            }
            return tmp;
        }
    }

    /**
     * Верните строку в формате
     * Тип_ВАЛЮТЫ: количество.XXXX
     * Тип_валюты: USD, EURO, RUB или KRONA
     * количество.XXXX - округленный amount до 4х знаков.
     * Округление по правилу: если >= 5, то в большую сторону, интаче - в меньшую
     * BigDecimal scale = amount.setScale(4, RoundingMode.HALF_UP);
     * <p>
     * Если тип валюты null, то вернуть:
     * null: количество.XXXX
     * Если количество денег null, то вернуть:
     * Тип_ВАЛЮТЫ: null
     * Если и то и то null, то вернуть:
     * null: null
     *
     * @return приведение к строке по указанному формату.
     */
    @Override
    public String toString() {
        return (this.type==null ? "null" : this.type.toString()) + ": " + (this.amount==null ? "null" : this.amount.setScale(4, RoundingMode.HALF_UP).toString());
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public MoneyType getType() {
        return type;
    }

    public static void main(String[] args) {
        Money money = new Money(MoneyType.USD, BigDecimal.valueOf(10.0000));
        Money money1 = new Money(MoneyType.USD, BigDecimal.valueOf(10.0000));
        System.out.println(money.hashCode());
        System.out.println(money1.hashCode());
        System.out.println(money.equals(money1));
    }
}
