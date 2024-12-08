'use client';

import React, { useState } from 'react';
import { Button} from '@/components/ui/Button';
import { motion } from 'framer-motion';
import { FaCreditCard, FaCashRegister } from 'react-icons/fa';

const Payment = () => {
    const [openCardModal, setOpenCardModal] = useState(false);
    const [cardDetails, setCardDetails] = useState({ number: '', expDate: '', cvv: '' });
    const [paymentMethod, setPaymentMethod] = useState(null);

    const handleCardInputChange = (e) => {
        const { name, value } = e.target;
        setCardDetails({ ...cardDetails, [name]: value });
    };

    const handlePaymentSubmit = () => {
        // Handle payment submission logic
        alert('Payment Submitted');
    };

    return (
        <div className="payment-container">
            <div className="payment-options">
                <div
                    className="payment-option card"
                    onClick={() => setOpenCardModal(true)}
                >
                    <motion.div
                        initial={{ opacity: 0 }}
                        animate={{ opacity: 1 }}
                        transition={{ duration: 0.6 }}
                    >
                        <FaCreditCard size={30} />
                        <span>Add Card</span>
                    </motion.div>
                </div>
                <div
                    className="payment-option cash"
                    onClick={() => setPaymentMethod('cash')}
                >
                    <motion.div
                        initial={{ opacity: 0 }}
                        animate={{ opacity: 1 }}
                        transition={{ duration: 0.6 }}
                    >
                        <FaCashRegister size={30} />
                        <span>Cash Payment</span>
                    </motion.div>
                </div>
            </div>

            {paymentMethod === 'cash' && (
                <div className="payment-cash">
                    <Button variant="outlined" onClick={handlePaymentSubmit}>Confirm Cash Payment</Button>
                </div>
            )}

            <Modal open={openCardModal} onClose={() => setOpenCardModal(false)}>
                <ModalContent>
                    <ModalHeader>Add Card Details</ModalHeader>
                    <ModalBody>
                        <Input
                            label="Card Number"
                            name="number"
                            value={cardDetails.number}
                            onChange={handleCardInputChange}
                            placeholder="Card Number"
                            className="input"
                        />
                        <div className="expiry-cvv">
                            <Input
                                label="Expiry Date"
                                name="expDate"
                                value={cardDetails.expDate}
                                onChange={handleCardInputChange}
                                placeholder="MM/YY"
                                className="input expiry"
                            />
                            <Input
                                label="CVV"
                                name="cvv"
                                value={cardDetails.cvv}
                                onChange={handleCardInputChange}
                                placeholder="CVV"
                                className="input cvv"
                            />
                        </div>
                    </ModalBody>
                    <ModalFooter>
                        <Button onClick={handlePaymentSubmit} color="primary">Pay with Card</Button>
                    </ModalFooter>
                </ModalContent>
            </Modal>
        </div>
    );
};

export default Payment;
