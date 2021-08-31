package sample;

import java.awt.image.SampleModel;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import com.pretty_tools.dde.DDEException;
import com.pretty_tools.dde.DDEMLException;
import com.pretty_tools.dde.client.DDEClientConversation;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;



public class Controller {

    public static final int indexMax=151;
    public String[] arrDDEStr = new String[indexMax];
    public int i, j, index;
    public String invNumber, numberLine, sResult;
    public Double[][] arrDataD = new Double[indexMax][11];

    public Double dResult;

    public final String SERVICE = "pegas";
    public String TOPIC;
    public int counter;
    public int counterError;

    public Double arithmeticMean = 0.0;
    public String ss;

    public boolean counterErrorBlock = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane formSample;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @FXML
    private Label Label1;

    @FXML
    private Label Label2;

    @FXML
    private Label Label3;

    @FXML
    private Label Label4;

    @FXML
    private Label Label5;

    @FXML
    private Label Label6;

    @FXML
    private Label Label7;

    @FXML
    private Label LabelInv;

    @FXML
    void initialize() {
        // массив для хранения ссылок
        Button2.setDisable(false);

        arrDDEStr[1] = "pegas|'{00000472-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[2] = "pegas|'{00000472-020a-0000-0000-040101010000}'!fRins.value";
        arrDDEStr[3] = "pegas|'{00000472-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[4] = "pegas|'{000004AC-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[5] = "pegas|'{000004AC-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[6] = "pegas|'{000004F3-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[7] = "pegas|'{000004F3-020a-0000-0000-040101010000}'!fRins.value";
        arrDDEStr[8] = "pegas|'{000004F3-020a-0000-0000-040102010000}'!fRins.value";
        arrDDEStr[9] = "pegas|'{000004F3-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[10] = "pegas|'{000004F3-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[11] = "pegas|'{000004F3-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[12] = "pegas|'{000004F5-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[13] = "pegas|'{000004F5-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[14] = "pegas|'{000004F7-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[15] = "pegas|'{0000050E-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[16] = "pegas|'{0000050E-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[17] = "pegas|'{0000050E-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[18] = "pegas|'{0000051D-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[19] = "pegas|'{0000051D-020a-0000-0000-040101010000}'!fRins.value";
        arrDDEStr[20] = "pegas|'{0000051D-020a-0000-0000-040102010000}'!fRins.value";
        arrDDEStr[21] = "pegas|'{0000051D-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[22] = "pegas|'{0000051D-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[23] = "pegas|'{0000051D-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[24] = "pegas|'{00000767-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[25] = "pegas|'{00000767-020a-0000-0000-040101010000}'!fRins.value";
        arrDDEStr[26] = "pegas|'{00000767-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[27] = "pegas|'{00000767-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[28] = "pegas|'{00000775-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[29] = "pegas|'{00000781-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[30] = "pegas|'{00000781-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[31] = "pegas|'{00001E58-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[32] = "pegas|'{00001E58-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[33] = "pegas|'{00001E58-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[34] = "pegas|'{000020EB-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[35] = "pegas|'{000020EB-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[36] = "pegas|'{000020EB-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[37] = "pegas|'{000020EC-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[38] = "pegas|'{000020EC-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[39] = "pegas|'{000020EC-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[40] = "pegas|'{00002101-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[41] = "pegas|'{00002101-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[42] = "pegas|'{00002108-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[43] = "pegas|'{00002108-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[44] = "pegas|'{00002108-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[45] = "pegas|'{00002179-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[46] = "pegas|'{00002179-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[47] = "pegas|'{00002894-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[48] = "pegas|'{00002894-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[49] = "pegas|'{00002894-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[50] = "pegas|'{00002895-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[51] = "pegas|'{00002895-020a-0000-0000-040101010000}'!fRins.value";
        arrDDEStr[52] = "pegas|'{00002895-020a-0000-0000-040102010000}'!fRins.value";
        arrDDEStr[53] = "pegas|'{00002895-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[54] = "pegas|'{00002895-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[55] = "pegas|'{00002895-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[56] = "pegas|'{00002896-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[57] = "pegas|'{00002896-020a-0000-0000-040101010000}'!fRins.value";
        arrDDEStr[58] = "pegas|'{00002896-020a-0000-0000-040102010000}'!fRins.value";
        arrDDEStr[59] = "pegas|'{00002896-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[60] = "pegas|'{00002896-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[61] = "pegas|'{00002896-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[62] = "pegas|'{0000289B-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[63] = "pegas|'{0000289B-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[64] = "pegas|'{0000289B-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[65] = "pegas|'{0000289C-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[66] = "pegas|'{0000289C-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[67] = "pegas|'{0000289C-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[68] = "pegas|'{0000289D-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[69] = "pegas|'{0000289D-020a-0000-0000-040101010000}'!fRins.value";
        arrDDEStr[70] = "pegas|'{0000289D-020a-0000-0000-040102010000}'!fRins.value";
        arrDDEStr[71] = "pegas|'{0000289D-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[72] = "pegas|'{0000289D-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[73] = "pegas|'{0000289D-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[74] = "pegas|'{000028A1-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[75] = "pegas|'{000028A1-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[76] = "pegas|'{000028A1-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[77] = "pegas|'{000028A3-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[78] = "pegas|'{000028A3-020a-0000-0000-040101010000}'!fRins.value";
        arrDDEStr[79] = "pegas|'{000028A3-020a-0000-0000-040102010000}'!fRins.value";
        arrDDEStr[80] = "pegas|'{000028A3-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[81] = "pegas|'{000028A3-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[82] = "pegas|'{000028A3-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[83] = "pegas|'{000028A4-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[84] = "pegas|'{000028A4-020a-0000-0000-040101010000}'!fRins.value";
        arrDDEStr[85] = "pegas|'{000028A4-020a-0000-0000-040102010000}'!fRins.value";
        arrDDEStr[86] = "pegas|'{000028A4-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[87] = "pegas|'{000028A4-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[88] = "pegas|'{000028A4-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[89] = "pegas|'{000028A5-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[90] = "pegas|'{000028A5-020a-0000-0000-040101010000}'!fRins.value";
        arrDDEStr[91] = "pegas|'{000028A5-020a-0000-0000-040102010000}'!fRins.value";
        arrDDEStr[92] = "pegas|'{000028A5-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[93] = "pegas|'{000028A5-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[94] = "pegas|'{000028A5-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[95] = "pegas|'{000028A6-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[96] = "pegas|'{000028A6-020a-0000-0000-040101010000}'!fRins.value";
        arrDDEStr[97] = "pegas|'{000028A6-020a-0000-0000-040102010000}'!fRins.value";
        arrDDEStr[98] = "pegas|'{000028A6-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[99] = "pegas|'{000028A6-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[100] = "pegas|'{000028A6-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[101] = "pegas|'{000028A7-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[102] = "pegas|'{000028A7-020a-0000-0000-040101010000}'!fRins.value";
        arrDDEStr[103] = "pegas|'{000028A7-020a-0000-0000-040102010000}'!fRins.value";
        arrDDEStr[104] = "pegas|'{000028A7-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[105] = "pegas|'{000028A7-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[106] = "pegas|'{000028A7-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[107] = "pegas|'{000028A8-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[108] = "pegas|'{000028A8-020a-0000-0000-040101010000}'!fRins.value";
        arrDDEStr[109] = "pegas|'{000028A8-020a-0000-0000-040102010000}'!fRins.value";
        arrDDEStr[110] = "pegas|'{000028A8-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[111] = "pegas|'{000028A8-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[112] = "pegas|'{000028A8-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[113] = "pegas|'{000028A9-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[114] = "pegas|'{000028A9-020a-0000-0000-040101010000}'!fRins.value";
        arrDDEStr[115] = "pegas|'{000028A9-020a-0000-0000-040102010000}'!fRins.value";
        arrDDEStr[116] = "pegas|'{000028A9-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[117] = "pegas|'{000028A9-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[118] = "pegas|'{000028A9-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[119] = "pegas|'{000028AA-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[120] = "pegas|'{000028AA-020a-0000-0000-040101010000}'!fRins.value";
        arrDDEStr[121] = "pegas|'{000028AA-020a-0000-0000-040102010000}'!fRins.value";
        arrDDEStr[122] = "pegas|'{000028AA-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[123] = "pegas|'{000028AA-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[124] = "pegas|'{000028AA-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[125] = "pegas|'{000031F9-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[126] = "pegas|'{000031F9-020a-0000-0000-040101010000}'!fRins.value";
        arrDDEStr[127] = "pegas|'{000031F9-020a-0000-0000-040102010000}'!fRins.value";
        arrDDEStr[128] = "pegas|'{000031F9-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[129] = "pegas|'{000031F9-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[130] = "pegas|'{000031F9-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[131] = "pegas|'{000031FA-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[132] = "pegas|'{000031FA-020a-0000-0000-040101010000}'!fRins.value";
        arrDDEStr[133] = "pegas|'{000031FA-020a-0000-0000-040102010000}'!fRins.value";
        arrDDEStr[134] = "pegas|'{000031FA-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[135] = "pegas|'{000031FA-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[136] = "pegas|'{000031FA-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[137] = "pegas|'{0000392F-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[138] = "pegas|'{0000392F-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[139] = "pegas|'{0000392F-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[140] = "pegas|'{00003C0F-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[141] = "pegas|'{00003C19-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[142] = "pegas|'{00003C19-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[143] = "pegas|'{00003C19-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[144] = "pegas|'{00003CB6-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[145] = "pegas|'{00003CB6-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[146] = "pegas|'{00003CB6-020a-0000-0000-040105010000}'!fRins.value";
        arrDDEStr[147] = "pegas|'{0000406E-020a-0000-0000-040100010000}'!fRins.value";
        arrDDEStr[148] = "pegas|'{0000406E-020a-0000-0000-040103010000}'!fRins.value";
        arrDDEStr[149] = "pegas|'{0000406E-020a-0000-0000-040104010000}'!fRins.value";
        arrDDEStr[150] = "pegas|'{000040F1-020a-0000-0000-040101010000}'!fRins.value";

        Button1.setOnAction(event ->{
            Button1.setDisable(true);
            Button2.setDisable(false);

            // обнулим массив
            for (i=0; i<indexMax; i++) {
                for (j=0; j<11; j++) {
                    arrDataD[i][j] = 0.0;
                }
            }

            // создание потока
            Thread myThread = new Thread(new Runnable() {
                public void run() //Этот метод будет выполняться в побочном потоке
                {
                    // зададим паузу в начале потока
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (Exception e) {
                        System.out.println("Exception: " + e);
                    }

                    Button1.setDisable(true);
                    Button2.setDisable(false);

                    // запрос данных Pegas
                    index = 1;
                    do {
                        // зададим паузу в начале потока
                        try {
                            TimeUnit.SECONDS.sleep(5);
                        } catch (Exception e) {
                            System.out.println("Exception: " + e);
                        }

                        System.out.println("");
                        System.out.println("Index = " + index);

                        // обнулим счетчики
                        counterError = 0;
                        arithmeticMean = 0.0;
                        // определим инв.номер и линию активного МДК
                        invNumber = arrDDEStr[index].substring(12,16);
                        numberLine = arrDDEStr[index].substring(37,38);

                        try {
                            final DDEClientConversation conversation = new DDEClientConversation();
                            // We can use UNICODE format if server prefers it
                            //conversation.setTextFormat(ClipboardFormat.CF_UNICODETEXT);
                            System.out.println("Connecting...");
                            TOPIC = arrDDEStr[index].substring(7,45);
                            conversation.connect(SERVICE, TOPIC);

                            try {
                                sResult = conversation.request("fRins.value");
                                while (sResult.equals("Ожидание") || sResult.equals("Запрос")) {
                                    sResult = conversation.request("fRins.value");
                                    System.out.println("fRins.value = " + sResult);
                                    TimeUnit.SECONDS.sleep(1);
                                    counterError++;
                                    // Counter overflow error
                                    if (counterError == 5) {
                                        counterError = 0;
                                        // возможно DDE интерфейс перегружен. Ожидаем 3 минуты и пробуем снова
                                        if (counterErrorBlock == false) {
                                            // счетчик переполнен первый раз
                                            counterErrorBlock = true;
                                            System.out.println("");
                                            System.out.println("counterErrorBlock = true");
                                            TimeUnit.MINUTES.sleep(3);
                                        } else {
                                            // счетчик перепонен повторно, дело дрянь
                                            System.out.println("Counter overflow error...");
                                            conversation.disconnect();
                                            JOptionPane.showMessageDialog(null, "Что-то пошло не так :-(",
                                                    "Warning", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                    }
                                }
                                counterErrorBlock = false;

                            } catch (DDEException e) {
                                System.out.println("Exception on request: " + e);
                            }

                            System.out.println("Disconnecting...");
                            conversation.disconnect();
                            System.out.println("Exit from thread");
                        } catch (DDEMLException e) {
                            System.out.println("DDEMLException: 0x" + Integer.toHexString(e.getErrorCode()) + " " + e.getMessage());
                        } catch (DDEException e) {
                            System.out.println("DDEClientException: " + e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Exception: " + e);
                        }

                        // sResult содержит данные МДК

                        // вернем в переменную dResult значение текущей изоляции в МОм
                        DDEDataProcessing ddeDataProcessing = new DDEDataProcessing();
                        dResult = ddeDataProcessing.DataConversion(sResult);

                        if (dResult == 0) {
                            // JOptionPane.showMessageDialog(null, "dResult = 0 :-(",
                            //        "Warning", JOptionPane.ERROR_MESSAGE);
                        }

                        // если dResult = 0, значит с текущим значение не все в порядке, записываем эту информацию
                        // в файл .txt и пропускаем вычисления по этой линии
                        if (dResult != 0) {
                            // передвигаем значения в массиве
                            for (i=1; i<10; i++){
                                arrDataD[index][i] = arrDataD[index][i+1];
                            }
                            arrDataD[index][10] = dResult;
                            // массив заполнен на текущий момент. Если если нулевые значения в массиве, то заполним
                            // их текущим значением. Это необходимо для немедленного начала проведения анализа
                            for (i=1; i<=10; i++) {
                                if (arrDataD[index][i] == 0) {
                                    arrDataD[index][i] = dResult;
                                }
                            }

                            // обновим все значения label до последних актуальных
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {

                                    //Update the text of label here
                                    switch (numberLine) {
                                        case "0":
                                            ss = "1A";
                                            break;
                                        case "1":
                                            ss = "1B";
                                            break;
                                        case "2":
                                            ss = "1AB";
                                            break;
                                        case "3":
                                            ss = "2A";
                                            break;
                                        case "4":
                                            ss = "2B";
                                            break;
                                        case "5":
                                            ss = "2AB";
                                            break;
                                        default:
                                            //если ни одно значение не выполняется
                                            JOptionPane.showMessageDialog(null, "Линия не определена :-(",
                                                    "Warning", JOptionPane.ERROR_MESSAGE);
                                            return;
                                    }

                                    LabelInv.setText("#" + invNumber + "  " + ss);
                                    Label1.setText(String.valueOf(arrDataD[index][4]));
                                    Label2.setText(String.valueOf(arrDataD[index][5]));
                                    Label3.setText(String.valueOf(arrDataD[index][6]));
                                    Label4.setText(String.valueOf(arrDataD[index][7]));
                                    Label5.setText(String.valueOf(arrDataD[index][8]));
                                    Label6.setText(String.valueOf(arrDataD[index][9]));
                                    Label7.setText(String.valueOf(arrDataD[index][10]));
                                }
                            });

                            // зададим паузу для прорисовки form
                            try {
                                TimeUnit.SECONDS.sleep(2);
                            } catch (Exception e) {
                                System.out.println("Exception: " + e);
                            }

                            // проведем вычисление динамики
                            for (i=3; i<10; i++) {
                                arithmeticMean += arrDataD[index][i];
                            }
                            // гашли среднеарифметическое за 7 измерений
                            arithmeticMean = arithmeticMean / 7;

                            // сравним среднеарифметическое с текущим значением. Если результат < 0.8, output alarm

                            if (dResult / arithmeticMean < 0.8 && dResult < 800) {
                                // set the red color of the label text

                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        //Update the text of label here
                                        LabelInv.setStyle("-fx-text-fill: red");
                                        Label7.setStyle("-fx-text-fill: red");
                                    }
                                });

                                // output alarm and play music
                                String bip = "sound.mp3";
                                Media hit = new Media(new File(bip).toURI().toString());
                                MediaPlayer mediaPlayer = new MediaPlayer(hit);
                                mediaPlayer.play();

                                // сообщении об отрицательной динамике
                                JOptionPane.showMessageDialog(null, "Тенденция к занижению :-(",
                                        "Warning", JOptionPane.ERROR_MESSAGE);

                                // персонал зафиксировал данные
                                mediaPlayer.stop();
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        //Update the text of label here
                                        LabelInv.setStyle("-fx-text-fill: black");
                                        Label7.setStyle("-fx-text-fill: blue");
                                    }
                                });

                            }

                        }

                        index++;
                        if (index == indexMax) {
                            index = 1;
                            // измерения линий закончены. Зададим паузу перед следующим циклом
                            try {
                                TimeUnit.MINUTES.sleep(5);
                            } catch (Exception e) {
                                System.out.println("Exception: " + e);
                            }
                            System.out.println("End line!!!");
                            System.out.println();

                        }

                    } while (index < indexMax);
                }
            });

            myThread.start();
        });

        Button2.setOnAction(event ->{

            //Создание потока
            Thread myThready = new Thread(new Runnable() {
                public void run() //Этот метод будет выполняться в побочном потоке
                {
                    System.out.println("Привет из побочного потока!");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            //Update the text of label here
                            Label1.setText("help");
                        }
                    });

                    try {
                        TimeUnit.SECONDS.sleep(2);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("ewewew");

                }
            });
            myThready.start();	//Запуск потока

            System.out.println("Главный поток завершён...");

        });

        Button3.setOnAction(event -> {
            System.exit(0);

        });

    }

}
