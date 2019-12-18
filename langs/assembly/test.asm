section .bss

section .data
    MSG: db "Hello World!!", 10
    MSG_LEN: equ $-MSG

section .text

global main

main:
   nop

.spike:
   mov eax, 0
   add eax, 5
   sub eax, 2

.print:
    mov eax, 4
    mov ebx, 1
    mov ecx, MSG
    mov edx, MSG_LEN
    int 80h;

.final:
    mov eax, 0
    ret