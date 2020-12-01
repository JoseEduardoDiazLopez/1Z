

import java.awt.Color;
import static java.awt.Color.blue;
import static java.awt.Color.green;
import static java.awt.Color.red;
import static java.lang.Thread.sleep;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeMath.random;

public class hilo extends Thread {

    Marquee puntero;
    int contador = 1;
    protected boolean pausado = false;
    protected boolean ejecutar = true;
    String[] frases = new String[]{
        "No intentes convertirte en un hombre de éxito, sino en un hombre de valor",
        "En la vida hay algo peor que el fracaso: el no haber intentado nada.",
        "No reírse de nada es de tontos, reírse de todo es de estúpidos",
        "Cásate con un arqueólogo. Cuanto más vieja te hagas, más encantadora te encontrará",
        "El mal nunca queda sin castigo, pero a veces el castigo es secreto",
        "Lo más razonable que se ha dicho sobre el matrimonio y sobre el celibato es esto: hagas lo que hagas te arrepentirás",
        "Las conversaciones siempre son peligrosas si se quiere esconder alguna cosa",
        "Las conversaciones siempre son peligrosas si se quiere esconder alguna cosa",
        "Cuando no hay humildad, las personas se degradan",
        "La tristeza es la cuna de inspiración de todo escrito",
        "En lo concerniente a las grandes sumas, lo más recomendable es no confiar en nadie",
        "La maldad no es algo sobrehumano, es algo menos que humano",
        "El orgullo de quienes no pueden edificar es destruir",
        "La vida es tan incierta, que la felicidad debe aprovecharse en el momento en que se presenta",
        "La vida es fascinante: sólo hay que mirarla a través de las gafas correcta",
        "Cuando el amor desenfrenado entra en el corazón, va royendo todos los demás sentimientos",
        "Para toda clase de males hay dos remedios; el tiempo y el silencio",
        "El amor es física, el matrimonio química",
        "La sabiduría humana se encierra por entero en estas dos palabras: ¡Confiar y esperar!",
        "No hace falta conocer el peligro para tener miedo; de hecho, los peligros desconocidos son los que inspiran más temor.",
        "En política sucede como en las matemáticas: todo lo que no es totalmente correcto, está mal.",
        "Vota a aquel que prometa menos. Será el que menos te decepcione. ",
        "El político debe ser capaz de predecir lo que va a pasar mañana, el mes próximo y el año que viene",
        "La política es el arte de servirse de los hombres haciéndoles creer que se les sirve a ellos.",
        "La política debería ser la profesión a tiempo parcial de todo ciudadano",
        "Cuando no se piensa lo que se dice es cuando se dice lo que se piensa",
        "Bienaventurados nuestros imitadores porque de ellos serán nuestros defectos",
        "La peor verdad sólo cuesta un gran disgusto. La mejor mentira cuesta muchos disgustos pequeños y al final, un disgusto grande",
        "La libertad no necesita alas, lo que necesita es echar raíces",
        "El verdadero amor no se conoce por lo que exige, sino por lo que ofrece",
        "Es tan fea la envidia que siempre anda por el mundo disfrazada, y nunca más odiosa que cuando pretende disfrazarse de justicia",
        "El pasado está escrito en la memoria y el futuro presente en el deseo",
        "El respeto al derecho ajeno es la paz",
        "Al amor lo pintan ciego y con alas. Ciego para no ver los obstáculos y con alas para salvarlo",
        "La alegría de hacer bien está en sembrar, no en recoger",
        "Si vivir es solo soñar, hagamos el bien soñando",
        "Perdonar supone siempre un poco de olvido, un poco de desprecio y un mucho de comodidad",
        "En cada niño nace la humanidad",
        "El Indulto es para los criminales, no para los defensores de la patria",
        "Lo más parecido a la mentira es el silencio, cuando se calla lo que no se quiere decir",
        "Ser feliz es cuestión de práctica",
    };

    public hilo(Marquee p) {
        this.puntero = p;
    }

    public void pausar() {
        pausado = !pausado;
    }

    public void detener() {
        ejecutar = false;
    }
 private boolean Despausado() {
        return !pausado;
    }
 
 private int getNumeroRandom(int min, int max){
       return ThreadLocalRandom.current().nextInt(min, max);
   }
    @Override
    public void run() {
        
        while (ejecutar) {
            try {
                if (Despausado()) {
                    puntero.lblFrases.setText(frases[getNumeroRandom(0, 40)]);
                    puntero.lblFrases.setForeground((Color.red));
                    puntero.lblcount.setText("Contador del Hilo: " + contador);
                    puntero.lblcount.setForeground((Color.green));
                   
                    contador++;
                    
                    if (contador == frases.length) {
                        contador = 0;
                    }
                }
                sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

   
}
