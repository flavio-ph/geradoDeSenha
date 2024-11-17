import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PasswordService {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    private static final SecureRandom RANDOM = new SecureRandom();

    public String generatePassword(int length) {
        if (length < 4) {
            throw new IllegalArgumentException("A senha deve ter pelo menos 4 caracteres.");
        }

        // Garante pelo menos um caractere de cada tipo
        StringBuilder password = new StringBuilder();
        password.append(getRandomCharacter(UPPERCASE));
        password.append(getRandomCharacter(LOWERCASE));
        password.append(getRandomCharacter(NUMBERS));
        password.append(getRandomCharacter(SPECIAL_CHARACTERS));

        // Preenche o restante da senha
        String allCharacters = UPPERCASE + LOWERCASE + NUMBERS + SPECIAL_CHARACTERS;
        for (int i = 4; i < length; i++) {
            password.append(getRandomCharacter(allCharacters));
        }

        // Embaralha a senha para evitar padrões previsíveis
        List<Character> characters = new ArrayList<>();
        for (char c : password.toString().toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle(characters);

        StringBuilder shuffledPassword = new StringBuilder();
        for (char c : characters) {
            shuffledPassword.append(c);
        }

        return shuffledPassword.toString();
    }

    private char getRandomCharacter(String characters) {
        return characters.charAt(RANDOM.nextInt(characters.length()));
    }
}
