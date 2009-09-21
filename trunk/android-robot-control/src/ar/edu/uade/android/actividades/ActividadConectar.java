package ar.edu.uade.android.actividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import ar.edu.uade.android.R;
import ar.edu.uade.android.dialogo.DialogoSalir;
import ar.edu.uade.android.utils.Constantes;
import ar.edu.uade.android.utils.Validador;

public class ActividadConectar
    extends Activity
    implements OnClickListener
{
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.conectar );
        Button buttonConectar = (Button) this.findViewById( R.id.ButtonConectar );

        buttonConectar.setOnClickListener( this );

        Button buttonCancelar = (Button) this.findViewById( R.id.ButtonCancelar );
        buttonCancelar.setOnClickListener( this );
    }

    @Override
    public void onClick( View v )
    {
        switch ( v.getId() )
        {
            case R.id.ButtonConectar:
            {
                // 1) Intentar conectar
                // 2) Lanzar un nuevo thread para streaming
                String robotIpAndPort = ( (EditText) this.findViewById( R.id.RobotIpAndPort ) ).getText().toString();
                robotIpAndPort = robotIpAndPort.replaceAll( " ", "" );
                
                if ( Validador.validarIpPuerto( robotIpAndPort ) )
                {
                    Toast.makeText( this, R.string.toast_conectando, Toast.LENGTH_SHORT ).show();
                    startActivity( new Intent( Constantes.INTENT_PANTALLA_WEBCAM_PRINCIPAL ) );
                }
                else
                {
                    Toast.makeText( this, R.string.toast_ip_o_puerto_invalidos, Toast.LENGTH_SHORT ).show();
                }
                break;
            }
            case R.id.ButtonCancelar:
            {
                new DialogoSalir( v.getContext(), this );
                break;
            }
            default:
                break;
        }
    }

}