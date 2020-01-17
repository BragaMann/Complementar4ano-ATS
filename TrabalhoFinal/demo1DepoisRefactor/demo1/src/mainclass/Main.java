package mainclass;

import controller.Controller;
import model.Parser;
import model.UMCarroJa;

import java.io.IOException;
import java.util.logging.Logger;


public class Main {

    private static final Logger LOGGER = Logger.getLogger(Parser.class.getName());

    // System.out.println -> LOGGER (smell)
    public static void main(String[] args) {
        UMCarroJa model = new UMCarroJa();
        try {
            model = UMCarroJa.read(".tmp");
            LOGGER.warning("adasdsada1");
        }
        catch (IOException | ClassNotFoundException e) {
            LOGGER.warning("adasdsada2");
            new Parser("db/logsPOO_carregamentoInicial.bak", model);
        }
        try { Thread.sleep(10000);} catch (Exception e) {LOGGER.warning(e.toString());} // smell -> preenchido o campo desta exception
        new Controller(model).run();
        try {
            model.save(".tmp");
        }
        catch (IOException ignored) {
            LOGGER.warning(ignored.toString());     // preenchido o campo desta exception -> smell
        }
    }
}