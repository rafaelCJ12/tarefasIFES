import java.lang.reflect.*;

public class Factory{
    Operacao factory(String nome) {
        try {
            Class<?> classe = Class.forName(nome); //passa o nome da classe
            Constructor<?> construtor = classe.getConstructor(); //obtem o construtor
            Object objeto = construtor.newInstance(); //cria uma nova instancia da classe

            return (Operacao) objeto;

        } 

        catch (InstantiationException e) {
			return null;
		} 
        
        catch (IllegalAccessException e) {
			return null;
		} 
        
        catch (ClassNotFoundException e) {
			return null;
		}

        catch (NoSuchMethodException e) {
			return null;
		}

        catch (InvocationTargetException e) {
			return null;
		}


    }
}