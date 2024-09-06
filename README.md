Sorter

**Описание**

Написать консольную программу, которая  сортировала построчный текст,  расположенный  в файле по одному из критериев:
1.	По алфавиту.
2.	По количеству символов в строке.
3.	По слову в строке заданному аргументом программы в виде порядкового номера.
      Отсортированный текст должен быть сохранен в другом файле.
      Каждая строка в исходном файле должна быть дополнена числом отображающим кол-во повторений данной строки в исходном файле.
      Программа должна иметь краткую инструкцию по использованию.

**Инструкция**

**Компиляция программы**

javac Sorter.java

**Запуск программы**

java Sorter <input_file> <output_file> <sort_criteria> <word_number>

**Сортировка по алфавиту**

java Sorter input.txt output.txt 1

**Сортировка по количеству символов в строке**

java Sorter input.txt output.txt 2

**Сортировка по третьему слову в строке**

java Sorter input.txt output.txt 3 2
