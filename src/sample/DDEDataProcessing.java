package sample;

public class DDEDataProcessing {
    public Double DataConversion(String sResultDDE) {

        boolean end;        // для определения на что оканчивается строка
        int i, gap;         // для цикла и определения длины строки
        double dResult = 0; //Double.valueOf(0);     // переменная для обработки значения изоляции

        if (sResultDDE == null) {
            return dResult;
        }

        if (sResultDDE.equals("<50 кОм")) {
            // значение <50 кОм не обрабатываем, переходим к следующему шагу
        } else {
            if (sResultDDE.equals("***")) {
                // значение *** не обрабатываем, переходим к следующему шагу
            } else {
                // проверяем оканчивается ли строка на кОм, если да то true
                end = sResultDDE.endsWith("кОм");
                if (end == true) {
                    // значение в кОм, значит уже отобразилось в ЕСМА, не обрабатываем
                } else {
                    // end = sResultDDE.endsWith("732,5 МОм\n");
                    end = sResultDDE.endsWith("МОм");
                    if (end == true) {
                        // данные в МОм (приведем к числовому значению в МОм)
                        gap = sResultDDE.indexOf(" ");
                        sResultDDE = sResultDDE.substring(0,gap);
                        // заменим запятую точкой
                        sResultDDE = sResultDDE.replace(",", ".");
                        dResult = Double.parseDouble(sResultDDE);

                    } else {
                        // данные в ГОм (приведем к числовому значению в МОм)
                        gap = sResultDDE.indexOf(" ");
                        sResultDDE = sResultDDE.substring(0,gap);

                        if (sResultDDE.equals(">3")) {
                            dResult = 3000.0;
                        } else {
                            // заменим запятую точкой
                            sResultDDE = sResultDDE.replace(",", ".");
                            dResult = Double.parseDouble(sResultDDE);
                            dResult = dResult * 1000;
                        }
                    }
                }
            }
        }
        return dResult;
    }

}
