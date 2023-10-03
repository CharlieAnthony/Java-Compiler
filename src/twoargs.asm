
main:

lw          a0, 8(sp)
li          a7, 1
ecall


li          a0, 10      # 0x0A: line feed
li          a7, 11
ecall

lw          a0, 12(sp)
li          a7, 1
ecall

li          t0, 1337
sw          t0, 16(sp)

lw          t0, 4(sp)
addi        sp, sp, 4
addi        sp, sp, 8
jr          t0
