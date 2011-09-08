import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;

public class BasicHttpAccess extends Authenticator {



	
	public PasswordAuthentication getPasswordAuthentication() {
			// I haven't checked getRequestingScheme() here, since for NTLM
			// and Negotiate, the username and password are all the same.
			System.err.println("Feeding username and password for "
					+ getRequestingScheme());
			return (new PasswordAuthentication(Constantes.kuser, Constantes.kpass.toCharArray()));
		
	}
	
	


	
	

	public static void main(String[] args) {
		Authenticator.setDefault(new BasicHttpAccess());
		URL url;
		try {
			url = new URL(Constantes.URL);
			InputStream ins;
			ins = url.openConnection().getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					ins));
			String str;
			String jsonData = null ;
			while ((str = reader.readLine()) != null) 
			{
				jsonData += str;
			}
			
			System.out.println(jsonData);
			
			
//			try {
//
//			    // cria um objeto a partir dos dados em JSON
//			    JSONObject jObj = new JSONObject( jsonData );
//
//			    // legal, tem um objeto, e agora pega a propriedade bindings
//			    // que � um array
//			    JSONArray jArray = jObj.getJSONArray( "bindings" );
//
//			    // itera pelo array
//			    for ( int i = 0; i < jArray.length(); i++ ) {
//
//			        // para cada posi��o do array, pega o objeto
//			        JSONObject jo = jArray.getJSONObject( i );
//
//			        // �, mas cada objeto tem um atributo chamado ircEvent
//			        // que � um array
//			        JSONArray jArrayIrcEvent = jo.optJSONArray( "ircEvent" );
//
//			        // itera pelo array obtido na posi��o atual
//			        for ( int j = 0; j < jArrayIrcEvent.length(); j++ ) {
//
//			            // pega o objeto de novo...
//			            JSONObject joi = jArrayIrcEvent.getJSONObject( j );
//
//			            // para cada objeto obtido, verifica se o atributo
//			            // existe. se existe, mostra os dado associado
//			            if ( joi.has( "ircEvent" ) ) {
//			                System.out.println( joi.getString( "ircEvent" ) );
//			            } else if ( joi.has( "bindings" ) ) {
//			                System.out.println( joi.getString( "bindings" ) );
//			            }
//
//			        }
//
//			    }
//
//			} catch ( JSONException exc ) {
//			    exc.printStackTrace();
//			}
//			
//			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
