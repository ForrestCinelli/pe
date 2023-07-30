; Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
; 
; For example, when the list is sorted into alphabetical order, COLIN, which is worth 
; 3 + 15 + 12 + 9 + 14 = 53, is the  938th name in the list. So, COLIN would obtain a score of  938 × 53 = 49714.
; 
; What is the total of all the name scores in the file?

; brew install sbcl
; sbcl --script 22.lisp
(defconstant CAP-A-OFFSET 65)
(defun letter-cost (letter) (+ 1 (- (char-code letter) CAP-A-OFFSET)))
(defun word-cost (i w) (* i (apply '+ (map 'list 'letter-cost w))))
(defun split (delimiter string &optional (acc nil)) (if (null string)
                                                        (reverse acc) ;base
                                                        (if (eq (car string) delimiter)
                                                            (split delimiter (cdr string) (cons nil acc)) ;drop comma, new empty accumulator
                                                            (split delimiter (cdr string) (cons (cons (car string) (car acc)) (cdr acc)))) ;add current char to current accumulator, continue
                                         ))

(defun map-with-index-impl (f acc list) (if (null list)
                                             acc 
                                             (map-with-index-impl f (cons (+ 1 (car acc))
                                                                          (cons (funcall f (car acc) (car list)) (cdr acc))) (cdr list)) ))
(defun map-with-index (f list &optional (init-idx 0)) (cdr (map-with-index-impl f (cons init-idx nil) list)))

(defun mysum (list &optional (acc 0)) (if (null list) acc (mysum (cdr list) (+ (car list) acc))))

; debug ideas: 

; (print (mysum `(1 2 3)))

; (print (word-cost 938 "COLIN"))
; (print (split #\, (coerce "COLIN,ABRAHAM" 'list)))
; (print (remove #\" "\"COLIN\",\"ABRAHAM\""))
; (print (remove #\, "COLIN,ABRAHAM,ADELINE"))
; (print (read (open "0022_names.txt")))
; (print (coerce (remove #\" (read-line (open "0022_names.txt"))) 'list))

; (print (map-with-index (lambda (i x) (+ i x)) (list 0 0 0 0 0)))

; (lambda (i w) (print (format NIL "~D ~A ~D" i w (word-cost i w))))

(print 
    (mysum 
        (map-with-index (lambda (i w) (word-cost i w))
                        (coerce 
                            (sort
                                (map 'list 
                                     (lambda (seq) (coerce (reverse seq) 'string))
                                     (split #\, (coerce (remove #\" (read-line (open "0022_names.txt"))) 'list)))
                                'string<
                            )
                            'list
                        )
                        1
        )
        
    )
)

