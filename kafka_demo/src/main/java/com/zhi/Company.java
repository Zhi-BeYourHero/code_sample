package com.zhi;

import lombok.*;

/**
 * @Author: luowenzhi
 * @CreateTime: 8/12/2021
 * @desc:
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private String name;
    private String address;
}
