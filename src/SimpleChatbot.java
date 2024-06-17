import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class SimpleChatbot {

    private static final String[] respostasPadrao = {
            "Olá! Como posso ajudar você?",
            "Estou aqui para ajudar. O que você precisa?",
            "Bem-vindo! Em que posso ser útil hoje?",
            "Oi! Como posso ser útil para você agora?"
    };

    private static final String[] perguntasFrequentes = {
            "qual é o seu nome",
            "como você está",
            "que horas são",
            "que dia é hoje",
            "qual é a previsão do tempo",
            "o que você pode fazer",
            "quem criou você",
            "qual é o significado da vida",
            "você gosta de música",
            "qual é a sua cor favorita"
    };

    private static final String[] respostasFAQ = {
            "Meu nome é Chatbot.",
            "Estou bem, obrigado por perguntar!",
            "Atualmente são " + LocalTime.now().toString().substring(0, 5) + " no horário de Brasília.",
            "Hoje é " + LocalDate.now() + ".",
            "Infelizmente não posso fornecer informações sobre o tempo no momento.",
            "Posso responder a perguntas simples e fornecer informações básicas.",
            "Fui criado por uma equipe de desenvolvedores talentosos.",
            "42.",
            "Eu não tenho preferências musicais, mas adoro ajudar você!",
            "Como um programa de computador, eu não tenho preferências pessoais, mas gosto de ver as pessoas felizes."
    };

    private static String nomeUsuario = "";

    public static String getRespostaPadrao() {
        Random random = new Random();
        int index = random.nextInt(respostasPadrao.length);
        return respostasPadrao[index];
    }

    public static String processarEntrada(String entrada) {
        if (entrada.contains("olá") || entrada.contains("oi")) {
            return "Olá, " + nomeUsuario + "! Como posso ajudar você?";
        } else if (entrada.contains("tchau") || entrada.contains("adeus")) {
            return "Até logo! Espero ter ajudado.";
        } else if (entrada.contains("tempo") || entrada.contains("clima")) {
            return "Desculpe, não posso fornecer informações sobre o tempo no momento.";
        } else if (entrada.contains("data")) {
            return "Hoje é " + LocalDate.now() + ".";
        } else if (entrada.contains("hora")) {
            return "Atualmente são " + LocalTime.now().toString().substring(0, 5) + " no horário de Brasília.";
        } else if (entrada.contains("seu nome")) {
            return "Meu nome é Chatbot.";
        } else if (entrada.contains("como você está")) {
            return "Estou bem, obrigado por perguntar!";
        } else {
            // Verifica perguntas frequentes
            for (int i = 0; i < perguntasFrequentes.length; i++) {
                if (entrada.contains(perguntasFrequentes[i])) {
                    return getRespostasFAQ(i);
                }
            }
            // Resposta padrão aleatória
            return getRespostaPadrao();
        }
    }

    private static String getRespostasFAQ(int i) {
        return switch (i) {
            case 0 -> "Meu nome é Chatbot.";
            case 1 -> "Estou bem, obrigado por perguntar!";
            case 2 -> "Atualmente são " + LocalTime.now().toString().substring(0, 5) + " no horário de Brasília.";
            case 3 -> "Hoje é " + LocalDate.now() + ".";
            case 4 -> "Infelizmente não posso fornecer informações sobre o tempo no momento.";
            case 5 -> "Posso responder a perguntas simples e fornecer informações básicas.";
            case 6 -> "Fui criado por uma equipe de desenvolvedores talentosos.";
            case 7 -> "42.";
            case 8 -> "Eu não tenho preferências musicais, mas adoro ajudar você!";
            case 9 -> "Como um programa de computador, eu não tenho preferências pessoais, mas gosto de ver as pessoas felizes.";
            default -> "Desculpe, não entendi sua pergunta.";
        };
    }

    public static void setNomeUsuario(String nomeUsuario) {
        SimpleChatbot.nomeUsuario = nomeUsuario;
    }

    public static String getNomeUsuario() {
        return nomeUsuario;
    }
}