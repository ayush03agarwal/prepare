package two;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}
