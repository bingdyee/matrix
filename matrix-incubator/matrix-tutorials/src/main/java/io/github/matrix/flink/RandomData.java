package io.github.matrix.flink;

import lombok.*;

/**
 * @author Noa Swartz
 * @date 2020/12/23
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RandomData {

    private Integer id;

    private Integer length;

    private String data;

    private Long timestamp;

}
