# Втора лабораториска вежба по Софтверско инженерство
## Јана Илијоска, бр. на индекс 212010
### Control Flow Graph <br>
![cfg](https://github.com/jna6/SI_2024_lab2_212010/assets/101054744/90d41523-f41b-4ec7-963d-60615fb5cb8d) <br>

### Цикломатска комплексност
Цикломатската комплексност на овој код е 10, истата ја добив преку формулата C=E-N+P+1, каде што Е е бројот на рабови, N е бројот на јазли и P е бројот на предикатни јазли. Во случајoв E=36, N=28 и P=1, па C=36-28+2=10.
### Тест случаи според критериумот Every branch <br>
1. Test null allItems - листата е празна, throws exception

2. Test checkCart(List.of(new Item("soap", "123x90", 350, 0)), 500) - невалиден баркод, throws exception

3. Test checkCart(List.of(new Item("cake", null, 600, 10)), 650) - нема баркод, throws exception

4. Test checkCart(List.of(new Item("towel", "0456789", 301, 0)), 100) - неисполнет услов (sum <= payment) и (item.getDiscount() > 0)

5. Test checkCart(List.of(new Item("milk", "01234567", 500, 5)), 500) -Сите услови се исполнети

### Тест случаи според Multiple Condition <br>
 
![Screenshot 2024-05-25 170641](https://github.com/jna6/SI_2024_lab2_212010/assets/101054744/19a345a2-f04b-407a-b972-eb21d4f1dad2)

